/*
COMPOSITE PRIMARY KEY reveng
*/
DECLARE

  l_table_name VARCHAR2(100);
  l_col_name   VARCHAR2(100);
  l_base_class VARCHAR2(100);
  l_class      VARCHAR2(100);
  l_cap        BOOLEAN;
  l_jtype      VARCHAR2(30);
  l_type       VARCHAR2(30);
  l_pass_type  VARCHAR2(15);
  l_pass_scale NUMBER(10);
  l_key_cnt    NUMBER;

  l_cnt        NUMBER;


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
          AND column_id > l_key_cnt
    ORDER BY table_name, column_id;

  CURSOR indvcols IS
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
          AND column_name = l_col_name
    ORDER BY table_name, column_id;

  CURSOR combpk IS
    SELECT
      c.owner,
      c.table_name,
      c.constraint_name,
      cc.COLUMN_NAME,
      cc.POSITION
    FROM all_cons_columns cc, all_constraints c
    WHERE c.owner = 'ALS'
          AND c.TABLE_NAME = l_table_name
          AND c.constraint_type = 'P'
          AND cc.CONSTRAINT_NAME = c.CONSTRAINT_NAME
          AND cc.TABLE_NAME = c.TABLE_NAME
    ORDER BY cc.POSITION;

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
  l_base_class := 'fwp.als.apptrack.hibernate.sponsor.dao.';

  l_table_name := 'ALS_APP_ADDITIONAL_DETAILS';

  SELECT count(1)
  INTO l_key_cnt
  FROM all_cons_columns cc, all_constraints c
  WHERE c.owner = 'ALS'
        AND c.TABLE_NAME = l_table_name
        AND c.constraint_type = 'P'
        AND cc.CONSTRAINT_NAME = c.CONSTRAINT_NAME
        AND cc.TABLE_NAME = c.TABLE_NAME;

  l_cnt := 0;

  FOR v_combpk IN combpk
  LOOP
    IF l_cnt = 0
    THEN
      l_table_name := lower(v_combpk.table_name);
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
          '   <table name="' || v_combpk.table_name || '" schema="' || v_combpk.owner || '" class="' || l_base_class ||
          l_class || '"> ');

      IF l_key_cnt = 1
      THEN
        dbms_output.put_line('     <primary-key>');
        dbms_output.put_line('         <generator class="sequence"> ');
        dbms_output.put_line('           <param name="sequence">pub_rid</param> ');
        dbms_output.put_line('         </generator>  ');
      ELSE
        dbms_output.put_line('     <primary-key id-class="' || l_base_class || l_class || 'IdPk" property="idPk">');
      END IF;
      l_cnt := l_cnt + 1;
    END IF;

    l_table_name := v_combpk.table_name;
    l_col_name := v_combpk.column_name;
    FOR v_indvcols IN indvcols
    LOOP

      l_jtype := '';
      l_type := '';
      l_pass_type := v_indvcols.DATA_TYPE;
      l_pass_scale := v_indvcols.DATA_SCALE;


      fndtype;

      IF l_jtype = 'VARCHAR'
      THEN
        dbms_output.put_line(
            '       <key-column name="' || v_combpk.column_name || '" jdbc-type="' || l_jtype || '" type="' || l_type ||
            '"></key-column>');
      ELSIF v_combpk.COLUMN_NAME IN ('CREATE_DATE', 'CREATE_USERID', 'LAST_MOD_DATE', 'LAST_MOD_USERID')
        THEN
          dbms_output.put_line('       <key-column name="' || v_combpk.column_name || '" exclude="true"></key-column>');
      ELSE
        dbms_output.put_line(
            '       <key-column name="' || v_combpk.column_name || '" jdbc-type="' || l_jtype || '" type="' || l_type ||
            '"></key-column>');
      END IF;
    END LOOP;

  END LOOP;
  dbms_output.put_line('     </primary-key>');

  FOR v_cols IN cols
  LOOP
    l_jtype := '';
    l_type := '';
    l_pass_type := v_cols.DATA_TYPE;
    l_pass_scale := v_cols.DATA_SCALE;


    fndtype;

    IF l_jtype != 'VARCHAR'
    THEN
      dbms_output.put_line(
          '     <column name="' || v_cols.column_name || '" jdbc-type="' || l_jtype || '" type="' || l_type ||
          '"></column>');
    ELSIF v_cols.COLUMN_NAME IN ('CREATE_DATE', 'CREATE_USERID', 'LAST_MOD_DATE', 'LAST_MOD_USERID')
      THEN
        dbms_output.put_line('     <column name="' || v_cols.column_name || '" exclude="true"></column>');
    ELSE
      dbms_output.put_line(
          '     <column name="' || v_cols.column_name || '" jdbc-type="' || l_jtype || '" type="' || l_type ||
          '"></column>');
    END IF;
  END LOOP;

  dbms_output.put_line('   </table>');

END loop;

