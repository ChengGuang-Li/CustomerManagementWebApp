ALTER TABLE Customer DROP CONSTRAINT CstmerNDSTRYTYPEid
ALTER TABLE Customer_Contact DROP CONSTRAINT CstmrCnCSTMRcstmrd
DROP TABLE Customer
DROP TABLE Customer_Contact
DROP TABLE Industry
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
