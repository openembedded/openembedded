DESCRIPTION = "Opkg Package Manager"
DESCRIPTION_libopkg = "Opkg Package Manager Library"
SECTION = "base"
LICENSE = "GPLv2"
SRCREV = "609"
PV = "0.1.8+svnr${SRCPV}"
CONFLICTS = "ipkg"
INC_PR = "r5"

SRC_URI = "svn://opkg.googlecode.com/svn;module=trunk;proto=http \
	   file://configure \
"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

do_install_prepend() {
  install -d ${D}${sysconfdir}/rcS.d
  install -m 0755 ${WORKDIR}/configure ${D}${sysconfdir}/rcS.d/S40configure
}

EXTRA_OECONF += " --disable-gpg \ 
                  --disable-openssl \ 
                  --disable-ssl-curl \
                  --disable-curl \
                  --disable-sha256"
