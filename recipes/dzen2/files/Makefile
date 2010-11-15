# dzen2 
#   (C)opyright MMVII Robert Manea

include config.mk

SRC = draw.c main.c util.c action.c
OBJ = ${SRC:.c=.o}

all: options dzen2 dzen-battery

options:
	@echo dzen2 build options:
	@echo "CFLAGS   = ${CFLAGS} ${INCS}"
	@echo "LDFLAGS  = ${LDFLAGS} ${LIBS}"
	@echo "CC       = ${CC}"

.c.o:
	@echo CC $<
	@${CC} -c ${CFLAGS} ${INCS} $<

${OBJ}: dzen.h action.h config.mk

dzen2: ${OBJ}
	@echo CC -o $@
	@${CC} -o $@ ${OBJ} ${LDFLAGS} ${LIBS}

dzen-battery: dzen-battery.c
	@${CC} -c ${CFLAGS} dzen-battery.c
	@${CC} -o dzen-battery dzen-battery.o ${LDFLAGS}

clean:
	@echo cleaning
	@rm -f dzen2 ${OBJ} dzen2-${VERSION}.tar.gz

dist: clean
	@echo creating dist tarball
	@mkdir -p dzen2-${VERSION}
	@cp -R LICENSE Makefile README config.mk action.h dzen.h ${SRC} dzen2-${VERSION}
	@tar -cf dzen2-${VERSION}.tar dzen2-${VERSION}
	@gzip dzen2-${VERSION}.tar
	@rm -rf dzen2-${VERSION}

install: all
	@echo installing executables to ${DESTDIR}${PREFIX}/bin
	@mkdir -p ${DESTDIR}${PREFIX}/bin
	@cp -f dzen2 ${DESTDIR}${PREFIX}/bin
	@chmod 755 ${DESTDIR}${PREFIX}/bin/dzen2
	@cp -f dzen-launcher ${DESTDIR}${PREFIX}/bin
	@chmod 755 ${DESTDIR}${PREFIX}/bin/dzen-launcher
	@cp -f dzen-battery ${DESTDIR}${PREFIX}/bin
	@chmod 755 ${DESTDIR}${PREFIX}/bin/dzen-battery
	@echo installing scripts to ${DESTDIR}${PREFIX}/share/dzen
	@mkdir -p ${DESTDIR}${PREFIX}/share/dzen/scripts
	@cp -f scripts/* ${DESTDIR}${PREFIX}/share/dzen/scripts
	@echo installing images to ${DESTDIR}${PREFIX}/share/dzen/images
	@mkdir -p ${DESTDIR}${PREFIX}/share/dzen/images
	@cp -f images/* ${DESTDIR}${PREFIX}/share/dzen/images

uninstall:
	@echo removing executable file from ${DESTDIR}${PREFIX}/bin
	@rm -f ${DESTDIR}${PREFIX}/bin/dzen2

.PHONY: all options clean dist install uninstall
