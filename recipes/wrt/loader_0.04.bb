SRC_URI = "http://wl500g.dyndns.org/loader/loader-${PV}.tar.gz \
	file://toolchain.patch;patch=1"

S = "${WORKDIR}/${P}"

do_compile() {
	make CROSS_COMPILE=${TARGET_PREFIX}
}

do_install() {
	install ${S}/loader.gz ${DEPLOY_DIR}/images/
}
SRC_URI[md5sum] = "c0b7c36232d3910c425d03e56d0f532b"
SRC_URI[sha256sum] = "6f11fc04a1f3f04ebb996723fc86ca363c3959ca1ef76d1057db9db3ea5a98d0"
