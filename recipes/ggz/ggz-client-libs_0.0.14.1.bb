DESCRIPTION = " Client libraries for GamingZone"
LICENSE = "LGPLv2"
DEPENDS = "libggz" 

PR = "r2"

SRC_URI = "http://ftp.belnet.be/packages/ggzgamingzone/ggz/${PV}/${PN}-${PV}.tar.gz \
           file://ggz-unbreak-m4.patch;patch=1 \
          "

inherit autotools

EXTRA_OECONF = "--with-ggz-dir=${STAGING_INCDIR}/../ \
                --with-libggz-includes=${STAGING_INCDIR} \
                --with-libggz-libraries=${STAGING_LIBDIR} \
               "

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do 
		sed -i -e s:'-I /usr/include -I /usr/local/include'::g $i
	done
}

FILES_${PN} += "${libdir}/ggz/ggzwrap ${datadir}/desktop-directories"



