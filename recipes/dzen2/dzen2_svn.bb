DESCRIPTION = "dzen is a general purpose messaging, notification and menu program."
LICENSE = "MIT"
DEPENDS = "virtual/libx11 libxft"
RDEPENDS_${PN} = "ttf-dejavu-sans xrandr"

SRCREV = "271"
PV = "0.8.5+svnr${SRCPV}"
PR = "r4"

SRC_URI = "svn://dzen.googlecode.com/svn/;module=trunk;proto=http \
	   file://dzen-extras.tar.gz \
	   file://Makefile"

S = "${WORKDIR}/trunk"

FILES_${PN} = "/usr/bin /usr/share/dzen"

do_configure() {
	install -m 0644 ${WORKDIR}/Makefile ${S}/Makefile
	cat <<EOF > config.mk
VERSION = ${PV}

PREFIX = /usr
MANPREFIX = /usr/share/man

INCS = -DDZEN_XFT -DVERSION=\"${PV}\" `pkg-config --cflags xft` 
LIBS = -lc -lX11 `pkg-config --libs xft`
EOF
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "5978620c2124c8a8ad52d7f17ce94fd7"
SRC_URI[sha256sum] = "5e4ce96e8ed22a4a0ad6cfafacdde0532d13d049d77744214b196c4b2bcddff9"
