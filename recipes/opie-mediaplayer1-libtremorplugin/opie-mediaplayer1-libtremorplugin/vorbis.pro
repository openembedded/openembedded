TEMPLATE  =   lib
CONFIG    +=  qt warn_on 
HEADERS   =   libtremorplugin.h libtremorpluginimpl.h
SOURCES         =   libtremorplugin.cpp libtremorpluginimpl.cpp
TARGET    =   tremorplugin
DESTDIR   =   $(OPIEDIR)/plugins/codecs
INCLUDEPATH += $(OPIEDIR)/include .. tremor
DEPENDPATH      +=  $(OPIEDIR)/include .. tremor 
LIBS            +=  -lqpe -lm -lvorbisidec
VERSION   =   1.0.0
include ( $(OPIEDIR)/include.pro )
