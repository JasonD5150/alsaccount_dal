/*
SINGLE PRIMARY KEY reveng
*/
DECLARE

  l_table_name VARCHAR2(100);
  l_base_class VARCHAR2(100);
  l_class      VARCHAR2(100);
  l_cap        BOOLEAN;
  l_jtype      VARCHAR2(15);
  l_type       VARCHAR2(30);
  l_pass_type  VARCHAR2(15);
  l_pass_scale NUMBER(10);

  CURSOR hdrcur IS
    SELECT
      c.owner,
      c.table_name,
      c.constraint_name,
      --cc.COLUMN_NAME
      listagg(cc.COLUMN_NAME, ', ')
      WITHIN GROUP (
        ORDER BY cc.COLUMN_NAME) listCol,
      count(cc.column_name)      col_cnt
    FROM all_cons_columns cc, all_constraints c
    WHERE c.owner = 'ALS'
          AND c.TABLE_NAME = 'ALS_PARTY_MASTER'
          AND c.constraint_type = 'P'
          AND cc.CONSTRAINT_NAME = c.CONSTRAINT_NAME
          AND cc.TABLE_NAME = c.TABLE_NAME
    GROUP BY c.owner, c.table_name, c.constraint_name
    ORDER BY c.table_name;

  CURSOR cols IS
    SELECT
      table_name,
      column_name,
      column_id,
      data_type,
      data_precision,
      data_scale
    FROM all_tab_cols
    WHERE owner = 'ALS'
          AND table_name = l_table_name
    ORDER BY table_name, column_id;


  PROCEDURE fndType IS

    BEGIN

      IF l_pass_type = 'NUMBER'
      THEN
        l_jtype := 'NUMERIC';
        IF nvl(l_pass_scale, 0) > 0
        THEN
          l_type := 'Double';
        ELSE
          l_type := 'Integer';
        END IF;
      ELSIF l_pass_type = 'VARCHAR2'
        THEN
          l_jtype := 'VARCHAR';
          l_type := 'String';
      ELSIF l_pass_type = 'DATE'
        THEN
          l_jtype := 'DATE';
          l_type := 'java.sql.Timestamp';
      END IF;
    END;

BEGIN
  --  l_base_class := 'fwp.bas.hibernate.dao.';
  l_base_class := 'fwp.als.apptrack.hibernate.info.dao.';

  FOR v_hdrcur IN hdrcur
  LOOP
    l_table_name := lower(v_hdrcur.table_name);
    l_class := '';
    l_cap := FALSE;
    FOR i IN 1..length(l_table_name)
    LOOP
      IF substr(l_table_name, i, 1) = '_'
      THEN
        l_cap := TRUE;
      ELSE
        IF NOT l_cap
        THEN
          IF i = 1
          THEN
            l_class := upper(substr(l_table_name, i, 1));
          ELSE
            l_class := l_class || substr(l_table_name, i, 1);
          END IF;
        ELSE
          l_class := l_class || InitCap(substr(l_table_name, i, 1));
          l_cap := FALSE;
        END IF;
      END IF;
    END LOOP;

    l_table_name := upper(l_table_name);
    dbms_output.put_line(
        '   <table name="' || v_hdrcur.table_name || '" schema="' || v_hdrcur.owner || '" class="' || l_base_class ||
        l_class || '"> ');

    FOR v_cols IN cols
    LOOP
      l_jtype := '';
      l_type := '';
      l_pass_type := v_cols.DATA_TYPE;
      l_pass_scale := v_cols.DATA_SCALE;

      IF v_hdrcur.col_cnt = 1
      THEN
        fndtype;

        IF v_hdrcur.listCol = v_cols.COLUMN_NAME
        THEN
          dbms_output.put_line('     <primary-key>');
          dbms_output.put_line('         <generator class="sequence"> ');
          dbms_output.put_line('           <param name="sequence">FWPOWNER.SSR_AUDIT_USER_HIST_SEQ</param> ');
          dbms_output.put_line('         </generator>  ');

          dbms_output.put_line(
              '       <key-column name="' || v_cols.column_name || '" jdbc-type="' || l_jtype || '" type="' || l_type ||
              '" />');

          dbms_output.put_line('     </primary-key>');
        ELSE
          dbms_output.put_line(
              '     <column name="' || v_cols.column_name || '" jdbc-type="' || l_jtype || '" type="' || l_type ||
              '"></column>');
        END IF;

      ELSE
        dbms_output.put_line(' table has a combined primary key that will need fixed');
        EXIT;
      END IF;
    END LOOP;

    dbms_output.put_line('   </table>');
  END LOOP;
END loop;

