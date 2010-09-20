DESCRIPTION = "Opkg Package Manager"
DESCRIPTION_libopkg = "Opkg Package Manager Library"
SECTION = "base"
LICENSE = "GPLv2"
SRCREV = ${OPKG_SRCREV}
PV = "0.1.8+svnr${SRCPV}"
INC_PR = "r2"

SRC_URI = "svn://opkg.googlecode.com/svn;module=trunk;proto=http \
	   file://configure \
"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

do_install_prepend() {
  install -d ${D}${sysconfdir}/rcS.d
  install -m 0755 ${WORKDIR}/configure ${D}${sysconfdir}/rcS.d/S98configure
}

EXTRA_OECONF += " --disable-gpg \ 
                  --disable-openssl \ 
                  --disable-ssl-curl \
                  --disable-curl \
                  --disable-sha256"
