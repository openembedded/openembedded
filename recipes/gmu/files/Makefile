# 
# Gmu Music Player
#
# Copyright (c) 2006-2010 Johannes Heimansberg (wejp.k.vu)
#
# File: Makefile  Created: 060904
#
# Description: Gmu's main Makefile
#
# This program is free software; you can redistribute it and/or
# modify it under the terms of the GNU General Public License
# as published by the Free Software Foundation; version 2 of
# the License. See the file COPYING in the Gmu's main directory
# for details.
#

ifeq ($(TARGET),)
TARGET=unknown
endif
include $(TARGET).mk

INCS+=$(COPTS) -Wall

OBJECTFILES=core.o ringbuffer.o util.o dir.o trackinfo.o playlist.o wejpconfig.o m3u.o audio.o charset.o fileplayer.o decloader.o feloader.o eventqueue.o oss_mixer.o hw_$(TARGET).o
ALLFILES=src/ Makefile *.mk gmu.png themes README.txt BUILD.txt COPYING gmu.conf.example *.keymap *.gpu *.dge *.nn gmuinput.*.conf gmu.*.conf
BINARY=gmu

all: $(BINARY) decoders frontends
	@$(STRIP) decoders/*.so
	@echo -e "All done for target \033[1m$(TARGET)\033[0m. \033[1m$(BINARY)\033[0m binary, \033[1mfrontends\033[0m and \033[1mdecoders\033[0m ready."

decoders: $(DECODERS_TO_BUILD)
	@echo -e "All \033[1mdecoders\033[0m have been built."

frontends: $(FRONTENDS_TO_BUILD)
	@echo -e "All \033[1mfrontends\033[0m have been built."

$(BINARY): $(OBJECTFILES)
	@echo -e "Linking \033[1m$(BINARY)\033[0m"
	@$(CC) $(OBJECTFILES) $(LIBS) -o $(BINARY)

projname=gmu-$(shell awk '/define VERSION_NUMBER/ { print $$3 }' src/core.h )

%.o: src/%.c
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) -fPIC $(INCS) -c -o $@ $<

%.o: src/frontends/sdl/%.c
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) -fPIC $(INCS) -Isrc/ -c -o $@ $<

dist: $(ALLFILES)
	@echo -e "Creating \033[1m$(projname).tar.gz\033[0m"
	@-rm -rf $(projname)
	@mkdir $(projname)
	@mkdir $(projname)/frontends
	@mkdir $(projname)/decoders
	@cp -rl --parents $(ALLFILES) $(projname)
	@tar chfz $(projname).tar.gz $(projname)
	@-rm -rf $(projname)

distbin: $(DISTFILES)
	@echo -e "Creating \033[1m$(projname)-$(DEVICE).zip\033[0m"
	@-rm -rf $(projname)-$(DEVICE)
	@-rm -rf $(projname)-$(DEVICE).zip
	@mkdir $(projname)-$(DEVICE)
	@cp -rl --parents $(DISTFILES) $(projname)-$(DEVICE)
	@-cp gmu.$(TARGET).conf $(projname)-$(DEVICE)/gmu.$(TARGET).conf
	@-cp $(TARGET).keymap $(projname)-$(DEVICE)/$(TARGET).keymap
	@$(STRIP) $(projname)-$(DEVICE)/gmu
	@zip -r $(projname)-$(DEVICE).zip $(projname)-$(DEVICE)
	@-rm -rf $(projname)-$(DEVICE)

install:
	@install -d $(DESTDIR)/usr/bin
	@install -d $(DESTDIR)/usr/lib/gmu
	@install -d $(DESTDIR)/etc/gmu
	@install -m 0755 gmu $(DESTDIR)/usr/bin
	@install -m 0644 gmu.conf $(DESTDIR)/etc/gmu
	@install -m 0644 gmuinput.conf $(DESTDIR)/etc/gmu
	@install -m 0644 default.keymap $(DESTDIR)/etc/gmu
	@cp -R decoders frontends themes $(DESTDIR)/usr/lib/gmu

clean:
	@-rm -rf *.o $(BINARY) decoders/*.so frontends/*.so
	@echo -e "\033[1mAll clean.\033[0m"

decoders/musepack.so: src/decoders/musepack.c id3.o charset.o trackinfo.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) $(LIBS) -shared -fpic -o decoders/musepack.so src/decoders/musepack.c id3.o charset.o trackinfo.o -lmpcdec 

decoders/vorbis.so: src/decoders/vorbis.c
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) $(LIBS) -shared -fpic -o decoders/vorbis.so src/decoders/vorbis.c src/util.c -lvorbisidec

decoders/splay.so: src/decoders/splay.cc util.o id3.o charset.o trackinfo.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CXX) -Wall -O2 -shared -fPIC -o decoders/splay.so src/decoders/splay.cc -g util.o id3.o charset.o trackinfo.o splay/libmpegsound.a -pg -g

decoders/flac.so: src/decoders/flac.c util.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) $(LIBS) -shared -fpic -o decoders/flac.so src/decoders/flac.c util.o -lFLAC

decoders/mpg123.so: src/decoders/mpg123.c util.o id3.o charset.o trackinfo.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) $(LIBS) -shared -fpic -o decoders/mpg123.so src/decoders/mpg123.c util.o id3.o -lmpg123

decoders/wavpack.so: src/decoders/wavpack.c util.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) $(LIBS) -shared -fpic -o decoders/wavpack.so src/decoders/wavpack.c util.o src/decoders/wavpack/*.c

decoders/mikmod.so: src/decoders/mikmod.c util.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) $(LIBS) -shared -fpic -o decoders/mikmod.so src/decoders/mikmod.c util.o -lmikmod

frontends/httpserv.so: src/frontends/httpserv.c util.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) -Wall -pedantic -shared -O2 -fpic -o frontends/httpserv.so src/frontends/httpserv.c util.o

frontends/sdl.so: src/frontends/sdl/sdl.c util.o kam.o skin.o textrenderer.o question.o filebrowser.o plbrowser.o about.o textbrowser.o coverimg.o coverviewer.o plmanager.o playerdisplay.o gmuwidget.o png.o jpeg.o bmp.o inputconfig.o help.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) $(LIBS) -Isrc/ -shared -fpic -o frontends/sdl.so src/frontends/sdl/sdl.c kam.o skin.o textrenderer.o question.o filebrowser.o plbrowser.o about.o textbrowser.o coverimg.o coverviewer.o plmanager.o playerdisplay.o gmuwidget.o png.o jpeg.o bmp.o inputconfig.o help.o

frontends/fltkfe.so: src/frontends/fltk/fltkfe.cxx
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CXX) -Wall -pedantic -shared -O2 -fpic -o frontends/fltkfe.so src/frontends/fltk/fltkfe.cxx -L/usr/lib/fltk/ -lfltk2 -lXext -lXinerama -lXft -lX11 -lXi -lm

frontends/log.so: src/frontends/log.c util.o
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) -shared -fpic -o frontends/log.so src/frontends/log.c util.o -lpthread

frontends/lirc.so: src/frontends/lirc.c
	@echo -e "Compiling \033[1m$<\033[0m"
	@$(CC) $(INCS) -shared -fpic -o frontends/lirc.so src/frontends/lirc.c -lpthread -llirc_client
