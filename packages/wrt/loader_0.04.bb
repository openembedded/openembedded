SRC_URI = "http://wl500g.dyndns.org/loader/loader-${PV}.tar.gz \
	file://toolchain.patch;patch=1"

S = "${WORKDIR}/${P}"

do_compile() {
	make CROSS_COMPILE=${TARGET_PREFIX}
}

do_install() {
	install ${S}/loader.gz ${DEPLOY_DIR}/images/
}