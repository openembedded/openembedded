TEMPLATE	= app

CONFIG		+= qt warn_on 

DESTDIR		= 

HEADERS		+= server.h \
		  qrr.h     \
		  serverinterface.h \
		  launchertab.h \
		  documentlist.h \
		  appicons.h \
		  taskbar.h \
                  runningappbar.h \
		  applauncher.h \
		  stabmon.h \
		  inputmethods.h \
		  systray.h \
		  wait.h \
		  shutdownimpl.h \
		  launcher.h \
		  launcherview.h \
		  calibrate/calibrate.h \
		  startmenu.h \
		  transferserver.h \
		  qcopbridge.h \
		  packageslave.h \
		  irserver.h \
		  firstuse.h \
		  syncdialog.h \
		  serverapp.h \
		  qprocess.h \
		  screensaver.h \
        mediummount/mediumwidget.h \
                  mediadlg.h

SOURCES		+= server.cpp \
		  qrr.cpp \
		  serverinterface.cpp \
		  launchertab.cpp \
		  documentlist.cpp \
		  appicons.cpp \
		  taskbar.cpp \
                  runningappbar.cpp \
		  applauncher.cpp \
		  stabmon.cpp \
		  inputmethods.cpp \
		  systray.cpp \
		  wait.cpp \
		  shutdownimpl.cpp \
		  launcher.cpp \
		  launcherview.cpp \
		  calibrate/calibrate.cpp \
		  transferserver.cpp \
		  packageslave.cpp \
   		  irserver.cpp \
		  qcopbridge.cpp \
		  startmenu.cpp \
		  main.cpp \
		  firstuse.cpp \
		  syncdialog.cpp \
		  serverapp.cpp \
		  qprocess.cpp \
		  qprocess_unix.cpp \
		  screensaver.cpp \
        mediummount/mediumwidget.cc \
                  mediadlg.cpp


INCLUDEPATH += calibrate
DEPENDPATH	+= calibrate

INCLUDEPATH += $(OPIEDIR)/include rsync
DEPENDPATH	+= rsync

INCLUDEPATH += mediummount
DEPENDPATH	+= mediummount


TARGET		= qpe

LIBS = -lqpe -lopiecore2 -lopieui2 -lopiesecurity2 -lqrsync

include ( $(OPIEDIR)/include.pro )
