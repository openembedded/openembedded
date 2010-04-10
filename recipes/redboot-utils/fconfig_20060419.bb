DESCRIPTION = "Tool to edit the Redboot config from userspace"
PR = "r1"

SRC_URI = "http://andrzejekiert.ovh.org/software/fconfig/fconfig-20060419.tar.gz"

S = ${WORKDIR}/fconfig
do_compile() {
	${MAKE}
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 755 ${S}/fconfig ${D}/${sbindir}
}

SRC_URI[md5sum] = "abc1aca11ee9c9d9b65057c3cf1ca88c"
SRC_URI[sha256sum] = "d109960dd5e306d4a8ab73e99bfd519ef1c7c674b33b9cfd8fdd61cbd43dac60"
