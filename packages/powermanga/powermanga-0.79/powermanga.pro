TEMPLATE        = app
CONFIG          = qt warn_on release
HEADERS         = \
		  src/caractere.hpp \
		  src/cercle.hpp \
		  src/chaine.hpp \
		  src/etbfonte1.hpp \
		  src/gfxroutines.hpp \
		  src/linux.hpp \
		  src/powermanga.hpp \
		  src/score.hpp

SOURCES         = \
		  src/afficheEtoiles.cpp \
		  src/bonus.cpp \
		  src/caractere.cpp \
		  src/chaine.cpp \
		  src/congratulations.cpp \
		  src/courbe.cpp \
		  src/displayFonte.cpp \
		  src/eclairExecution.cpp \
		  src/ennemis_execution.cpp \
		  src/etbfonte1.cpp \
		  src/explosionExecution.cpp \
		  src/fntscrol.cpp \
		  src/gardien12.cpp \
		  src/gardien13.cpp \
		  src/gardien14.cpp \
		  src/gardiens.cpp \
		  src/gfxbase.cpp \
		  src/gfxroutines.cpp \
		  src/grille.cpp \
		  src/initialiseGameOver.cpp \
		  src/inits_game.cpp \
		  src/keymap.cpp \
		  src/linuxroutines.cpp \
		  src/main.cpp \
		  src/menu.cpp \
		  src/metors.cpp \
		  src/onde.cpp \
		  src/options.cpp \
		  src/playanim.cpp \
		  src/powermanga.cpp \
		  src/powmangasub1.cpp \
		  src/powmangasub2.cpp \
		  src/score.cpp \
		  src/sdl_mixer.cpp \
		  src/sdl_tlk.cpp \
		  src/special_enemy.cpp \
		  src/tirsExecutions.cpp \
		  src/tirsJoueur.cpp \
		  src/touchesTriches.cpp \
		  src/vaisseau.cpp \
		  src/xwindow.cpp
		  
INCLUDEPATH     += $(QPEDIR)/include
DEPENDPATH      += $(QPEDIR)/include

CFLAGS      	+= `$(QPEDIR)/bin/sdl-config --cflags`
LIBS            += -lSDLmain -lSDL -lSDL_mixer -lpthread -lqpe
OBJECTS_DIR  	= obj
MOC_DIR      	= moc
TARGET          = powermanga
VERSION		= 0.79
