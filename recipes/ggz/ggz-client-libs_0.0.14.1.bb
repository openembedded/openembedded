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




SRC_URI[md5sum] = "299eaa93721b1d867b5bf7dc6ac764b0"
SRC_URI[sha256sum] = "0a7bec1a381a450f650890b36253893df0001873ba1f414573a4247298107680"
