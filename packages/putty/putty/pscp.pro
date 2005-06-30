TEMPLATE = app
TARGET = pscp
CONFIG = warn_on release console
DEPENDPATH += unix charset
INCLUDEPATH += . unix charset

SOURCES += be_none.c scp.c sftp.c unix/uxsftp.c

LIBS += -L. -lputty

