TEMPLATE 	= lib
CONFIG   	+=  qt warn_on 
HEADERS   	= libmadplugin.h libmadpluginimpl.h
SOURCES   	= libmadplugin.cpp libmadpluginimpl.cpp
TARGET   	= madplugin
DESTDIR   	= $(OPIEDIR)/plugins/codecs
INCLUDEPATH += $(OPIEDIR)/include ..
DEPENDPATH      +=  ..
LIBS            += -lqpe -lm -lmad
VERSION   =   1.0.0

include ( $(OPIEDIR)/include.pro )
	
DEFINES += FPM_INTEL

system(echo $QMAKESPEC | grep -s sharp) {
	DEFINES -= FPM_INTEL
	DEFINES += FPM_ARM
}

system(echo $QMAKESPEC | grep -s ipaq) {
	DEFINES -= FPM_INTEL
	DEFINES += FPM_ARM
}

system(echo $QMAKESPEC | grep -s mipsel) {
	DEFINES -= FPM_INTEL
	DEFINES += FPM_MIPS
}

system(echo $QMAKESPEC | grep -s mnci) {
	DEFINES -= FPM_INTEL
	DEFINES += FPM_ARM
}

system(echo $QMAKESPEC | grep -s arm) {
	DEFINES -= FPM_INTEL
	DEFINES += FPM_ARM
}

system(echo $QMAKESPEC | grep -s simpad) {
	DEFINES -= FPM_INTEL
	DEFINES += FPM_ARM
}

system(echo $QMAKESPEC | grep -s yopy) {
	DEFINES -= FPM_INTEL
	DEFINES += FPM_ARM
}


