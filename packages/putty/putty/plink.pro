TEMPLATE = app
TARGET = plink
CONFIG = warn_on release console
DEPENDPATH += unix charset
INCLUDEPATH += . unix charset

SOURCES += be_all.c uxplink.c

LIBS += -L. -lputty

