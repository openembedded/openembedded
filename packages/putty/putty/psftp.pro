TEMPLATE = app
TARGET = psftp
CONFIG = warn_on release console
DEPENDPATH += unix charset
INCLUDEPATH += . unix charset

SOURCES += be_none.c psftp.c sftp.o unix/uxsftp.c

LIBS += -L. -lputty

