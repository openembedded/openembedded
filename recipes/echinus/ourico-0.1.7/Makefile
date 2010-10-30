# ourico - EWMH taskbar
# © 2006-2007 Anselm R. Garbe, Sander van Dijk
# © 2008 Alexander Polakov

include config.mk

SRC = ourico.c
OBJ = ${SRC:.c=.o}

all: options ourico

options:
	@echo ourico build options:
	@echo "CFLAGS   = ${CFLAGS} ${INCS}"
	@echo "LDFLAGS  = ${LDFLAGS} ${LIBS}"
	@echo "CC       = ${CC}"

.c.o:
	@echo CC $<
	@${CC} -c ${CFLAGS} ${INCS} $<

${OBJ}: config.h config.mk

ourico: ${OBJ}
	@echo CC -o $@
	@${CC} -o $@ ${OBJ} ${LDFLAGS} ${LIBS}

clean:
	@echo cleaning
	@rm -f ourico ${OBJ} ourico-${VERSION}.tar.gz

dist: clean
	@echo creating dist tarball
	@mkdir -p ourico-${VERSION}
	@cp -R ouricorc LICENSE Makefile ourico.1 README config.mk config.h ${SRC} ourico-${VERSION}
	@tar -cf ourico-${VERSION}.tar ourico-${VERSION}
	@gzip ourico-${VERSION}.tar
	@rm -rf ourico-${VERSION}

install: all
	@echo installing executable file to ${DESTDIR}${PREFIX}/bin
	@mkdir -p ${DESTDIR}${PREFIX}/bin
	@cp ourico ${DESTDIR}${PREFIX}/bin
	@chmod 755 ${DESTDIR}${PREFIX}/bin/ourico
	@echo installing manual page to ${DESTDIR}${MANPREFIX}/man1
	@mkdir -p ${DESTDIR}${MANPREFIX}/man1
	@sed "s/VERSION/${VERSION}/g" < ourico.1 > ${DESTDIR}${MANPREFIX}/man1/ourico.1
	@chmod 644 ${DESTDIR}${MANPREFIX}/man1/ourico.1
	@echo install ouricorc to ${DESTDIR}${CONF}
	@mkdir -p ${DESTDIR}${CONF}
	@cp ouricorc ${DESTDIR}${CONF}

uninstall:
	@echo removing executable file from ${DESTDIR}${PREFIX}/bin
	@rm -f ${DESTDIR}${PREFIX}/bin/ourico
	@echo removing manual page from ${DESTDIR}${MANPREFIX}/man1
	@rm -f ${DESTDIR}${MANPREFIX}/man1/ourico.1
	@echo removing ouricorc from  ${DESTDIR}${PREFIX}/share/examples/ourico
	@rm -rf ${DESTDIR}${PREFIX}/share/examples/ourico

.PHONY: all options clean dist install uninstall
