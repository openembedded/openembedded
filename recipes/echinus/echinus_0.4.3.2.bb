DESCRIPTION = "echinus is a simple and lightweight tiling and floating window manager for X11."
SECTION = "x11/wm"
LICENSE = "MIT"
PR = "r2"

DEPENDS = "virtual/libx11 libxft libxrandr"

SRC_URI = "http://plhk.ru/static/echinus/old/echinus-${PV}.tar.gz \
	   file://Makefile"

SRC_URI_append_jlime = " file://echinus-jlime.patch "

S = "${WORKDIR}/echinus-${PV}"

CONFFILES_${PN} = "/etc/echinus/echinusrc"

do_configure() {
	mv ${WORKDIR}/Makefile ${S}/Makefile
	cat <<EOF > config.mk
VERSION = ${PV}

PREFIX = /usr
MANPREFIX = /usr/share/man
CONF = /etc/echinus

INCS = -I. `pkg-config --cflags xft` -Wall -DXRANDR=1 -DVERSION=\"${PV}\" -DSYSCONFPATH=\"${sysconfdir}/${PACKAGE}\"
LIBS = -lc -lX11 -lXrandr `pkg-config --libs xft`
EOF
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "465314d17e9cd63ff2b18ff8f0701305"
SRC_URI[sha256sum] = "bf41fef15b1d68c91af8f3ad636156e146dd9837638acc174048f58fe9761f3e"
