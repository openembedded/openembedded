DESCRIPTION = "Mozilla's SSL and TLS implementation"
HOMEPAGE = "http://www.mozilla.org/projects/security/pki/nss/"

LICENSE = "MPL1.1 GPL LGPL"

PR = "r3"

DEPENDS = "sqlite3 nspr"

SRC_URI = "\
	http://ftp.mozilla.org/pub/mozilla.org/security/nss/releases/NSS_3_12_RTM/src/${PN}-${PV}.tar.gz;name=archive \
	file://25_entropy.dpatch;patch=1 \
	file://38_mips64_build.dpatch;patch=1 \
	file://80_security_build.dpatch;patch=1 \
	file://80_security_tools.dpatch;patch=1 \
	file://81_sonames.dpatch;patch=1 \
	file://85_security_load.dpatch;patch=1 \
	file://90_realpath.dpatch;patch=1 \
	file://91_build_pwdecrypt.dpatch;patch=1 \
	file://95_add_spi+cacert_ca_certs.dpatch;patch=1 \
	file://build-fix.patch;patch=1 \
    file://nss.pc.in \
"

SRC_URI[archive.md5sum] = "917f4e05f3982bd7fceaede197f0e1d4"
SRC_URI[archive.sha256sum] = "d30a7470b82a73ed442525b365afaf00427204e3771edfeab05743acca97122b"

S = "${WORKDIR}/nss-${PV}/mozilla"

TD = "${S}/tentative-dist"
TDS = "${S}/tentative-dist-staging"

PARALLEL_MAKE = ""

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	oe_runmake -C security/nss \
		build_coreconf \
		build_dbm \
		export libs program \
		MOZILLA_CLIENT=1 \
		BUILD_OPT=1 \
		OS_TARGET=Linux \
		OS_TEST="${TARGET_ARCH}" \
		NSPR_INCLUDE_DIR="${STAGING_INCDIR}/mozilla/nspr" \
		NSPR_LIB_DIR="${STAGING_LIBDIR}" \
		SQLITE3_INCLUDE_DIR="${STAGING_INCDIR}" \
		OPTIMIZER="${CFLAGS}" \
		NS_USE_GCC=1 \
		NSS_USE_SYSTEM_SQLITE=1 \
		NSS_ENABLE_ECC=1 \
		DEFAULT_COMPILER="${CC}" \
		CC="${CC}" \
		CCC="${CXX}" \
		CXX="${CXX}" \
		RANLIB="${RANLIB}" \
		NATIVE_CC="${BUILD_CC}" \
		NATIVE_FLAGS="${BUILD_CFLAGS}"

}

do_install() {
	oe_runmake -C security/nss \
		install \
		MOZILLA_CLIENT=1 \
		BUILD_OPT=1 \
		OS_TARGET=Linux \
		OS_TEST="${TARGET_ARCH}" \
		NSPR_INCLUDE_DIR="${STAGING_INCDIR}/mozilla/nspr" \
		NSPR_LIB_DIR="${STAGING_LIBDIR}" \
		NS_USE_GCC=1 \
		NSS_USE_SYSTEM_SQLITE=1 \
		NSS_ENABLE_ECC=1 \
		SOURCE_LIB_DIR="${TD}/${libdir}" \
		SOURCE_BIN_DIR="${TD}/${bindir}"

	install -d ${D}/${libdir}/nss

	for shared_lib in ${TD}/${libdir}/*.so
	do
		cp $shared_lib ${D}/${libdir}/nss
	done

	install -d ${D}/${includedir}/mozilla/nss
	install -m 644 -t ${D}/${includedir}/mozilla/nss dist/public/nss/*

	for static_lib in ${TD}/${libdir}/*.a
	do
		oe_libinstall -C ${TD}/${libdir} `basename $static_lib .a` ${D}/${libdir}/nss
	done

	install -d ${D}/${bindir}
	for binary in ${TD}/${bindir}/*
	do
		install -m 755 -t ${D}/${bindir} $binary
	done

	install -d ${D}${libdir}/pkgconfig/
	sed 's/@VERSION@/${PV}/' ${WORKDIR}/nss.pc.in > ${D}${libdir}/pkgconfig/nss.pc

}

FILES_${PN} = "${bindir} ${libdir}/nss/*.so"
FILES_${PN}-static += "${libdir}/nss/*.a"
