DESCRIPTION = "Tool to edit the Redboot config from userspace"
PR = "r0"

SRC_URI = "http://andrzejekiert.ovh.org/software/fconfig/fconfig-20060419.tar.gz"

S = ${WORKDIR}/fconfig
do_compile() {
	${MAKE}
}