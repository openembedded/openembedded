# echinus wm - a window manager
# © 2006-2007 Anselm R. Garbe, Sander van Dijk
# © 2008 Alexander Polakov

include config.mk

PIXMAPS = close.xbm iconify.xbm max.xbm 
FILES = draw.c parse.c ewmh.c config.h
SRC = echinus.c
OBJ = ${SRC:.c=.o}

all: options echinus ${HEADERS}

options:
	@echo echinus build options:
	@echo "CFLAGS   = ${CFLAGS} ${INCS}"
	@echo "LDFLAGS  = ${LDFLAGS} ${LIBS}"
	@echo "CC       = ${CC}"

.c.o:
	@echo CC $<
	@${CC} -c ${CFLAGS} ${INCS} $<

${OBJ}: config.mk

echinus: ${OBJ} ${FILES}
	@echo CC -o $@
	@${CC} -o $@ ${OBJ} ${LDFLAGS} ${LIBS}

clean:
	@echo cleaning
	@rm -f echinus ${OBJ} echinus-${VERSION}.tar.gz *~

dist: clean
	@echo creating dist tarball
	@mkdir -p echinus-${VERSION}
	@cp -R LICENSE Makefile README config.mk \
		echinus.1 echinusrc ${SRC} ${FILES} ${PIXMAPS} echinus-${VERSION}
	@tar -cf echinus-${VERSION}.tar echinus-${VERSION}
	@gzip echinus-${VERSION}.tar
	@rm -rf echinus-${VERSION}

install: all
	@echo installing executable file to ${DESTDIR}${PREFIX}/bin
	@mkdir -p ${DESTDIR}${PREFIX}/bin
	@cp -f echinus ${DESTDIR}${PREFIX}/bin
	@chmod 755 ${DESTDIR}${PREFIX}/bin/echinus
	@echo installing configuration file and pixmaps to ${DESTDIR}${CONF}
	@mkdir -p ${DESTDIR}${CONF}
	@cp echinusrc ${DESTDIR}${CONF}
	@cp ${PIXMAPS} ${DESTDIR}${CONF}
	@echo installing manual page to ${DESTDIR}${MANPREFIX}/man1
	@mkdir -p ${DESTDIR}${MANPREFIX}/man1
	@sed "s/VERSION/${VERSION}/g;s|CONFDIR|${CONF}|g" < echinus.1 > ${DESTDIR}${MANPREFIX}/man1/echinus.1
	@echo installing README to ${DESTDIR}${PREFIX}/share/doc/echinus
	@mkdir -p ${DESTDIR}${PREFIX}/share/doc/echinus
	@sed "s|CONFDIR|${CONF}|" < README > ${DESTDIR}${PREFIX}/share/doc/echinus/README

uninstall:
	@echo removing executable file from ${DESTDIR}${PREFIX}/bin
	@rm -f ${DESTDIR}${PREFIX}/bin/echinus
	@echo removing manual page from ${DESTDIR}${MANPREFIX}/man1
	@rm -f ${DESTDIR}${MANPREFIX}/man1/echinus.1
	@echo removing configuration file and pixmaps from ${DESTDIR}${PREFIX}${CONF}
	@rm -rf ${DESTDIR}${PREFIX}${CONF}

.PHONY: all options clean dist install uninstall
