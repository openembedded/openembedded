DESCRIPTION = "Web interface"
LICENSE = "GPL"

PV = "0.0.3+svnr${SRCPV}"
SRCREV = "4737"

SRC_URI = "svn://x-wrt.googlecode.com/svn;module=trunk;proto=http"

S = "${WORKDIR}/trunk"

do_compile() {
        cd ${S}/package/webif/ 
        ${CC} ${CFLAGS} \
                -D_METAPACK \
                -I${STAGING_INCDIR} -include endian.h \
                ${LDFLAGS} \
                -o ${S}/webifmetabin \
                src/int2human/main.c src/int2human/human_readable.c \
                src/wepkeygen/keygen.c src/wepkeygen/md5.c \
                src/webif-page.c src/bstrip.c src/webifmetabin.c
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/webifmetabin ${D}${bindir}/

	install -d ${D}${sysconfdir}	
	cp -dPr ${S}/package/webif/files/etc/* ${D}${sysconfdir}/

	install -d ${D}${libdir}
	cp -dPr ${S}/package/webif/files/usr/lib/* ${D}${libdir}/

	find ${D} -name ".svn" | xargs rm -r || true
}


RDEPENDS_${PN} = "haserl ${IPKG_VARIANT} cron"
