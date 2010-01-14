DESCRIPTION = "Productive gtk+ devel prodder"
DEPENDS = "gtk+"

PR = "r3"

inherit pkgconfig

SRC_URI = "file://pixops-test.c \
           file://gtk-logo-rgb.gif"

do_configure() {
	cp ${WORKDIR}/pixops-test.c ${S}
	cp ${WORKDIR}/gtk-logo-rgb.gif ${S}
}

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} `pkg-config gtk+-2.0 --libs --cflags` `pkg-config pango --libs --cflags` -lXfixes -lz -lpangoft2-1.0 -lgpg-error -lXdmcp -lXcursor -lexpat -lXau -lgcrypt -lXext -lXinerama -lXrandr -o pixops-test pixops-test.c
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/pixops-test
	install -m 755 pixops-test ${D}${bindir}
	install -m 644 gtk-logo-rgb.gif ${D}${datadir}/pixops-test
}
