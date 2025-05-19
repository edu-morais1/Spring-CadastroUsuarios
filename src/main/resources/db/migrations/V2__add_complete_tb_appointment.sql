--V2: Migrations para adicionr a coluna bool de compromisso completo ou nao.
ALTER TABLE TB_APPOINTMENTS
    ADD COLUMN is_complete BOOLEAN DEFAULT FALSE;