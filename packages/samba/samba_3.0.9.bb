SRC_URI := "http://us2.samba.org/samba/ftp/stable/samba-${PV}.tar.gz \
	   file://${FILESDIR}/configure.patch;patch=1 \
	   file://${FILESDIR}/cifs.patch;patch=1"
S := ${WORKDIR}/${P}/source

include samba.inc
