DESCRIPTION = "ourico is s simple EWMH-compatible panel designed for use with echinus."
SECTION = "x11/wm"
LICENSE = "MIT"
PR = "r0"

DEPENDS = "virtual/libx11 libxft"

SRC_URI = "http://plhk.ru/static/ourico/ourico-${PV}.tar.gz \
	   file://Makefile"

SRC_URI_append_jlime = " file://ourico-jlime.patch "

S = "${WORKDIR}/ourico-${PV}"

CONFFILES_${PN} = "/etc/echinus/ouricorc"

do_configure() {
	mv ${WORKDIR}/Makefile ${S}/Makefile
	cat <<EOF > config.mk
VERSION = ${PV}

PREFIX = /usr
MANPREFIX = /usr/share/man
CONF = /etc/echinus

INCS = -I. `pkg-config --cflags xft` -DVERSION=\"${PV}\"
LIBS = -lc -lX11 `pkg-config --libs xft`
EOF
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "6b8af8bf5afc7b9b9f13500c25b19db4"
SRC_URI[sha256sum] = "29318f5002685216ef754998981e3742cf88952f20879dcd3e90d386ef91fe32"
