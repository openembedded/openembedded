DESCRIPTION = "Command line tool and library for client-side URL transfers."
LICENSE = "MIT"
SECTION = "console/network"

SRC_URI = "http://curl.haxx.se/download/curl-${PV}.tar.bz2;name=tarball \
           file://pkgconfig_fix.patch;patch=1"
S = "${WORKDIR}/curl-${PV}"

INC_PR = "r3"

CURL_FEATURES ?= "zlib,gnutls,cookies,crypto-auth,dict,file,ftp,http,telnet,tftp"
# other allowed features: ipv6, ares, openssl

inherit autotools pkgconfig binconfig

EXTRA_OECONF = " \
                --without-libssh2 \
		--with-random=/dev/urandom \
		--without-libidn \
		"

python __anonymous() {
	f = bb.data.getVar("CURL_FEATURES", d, True).split(",")
        oeconf = bb.data.getVar("EXTRA_OECONF", d, False)
        deps = bb.data.getVar("DEPENDS", d, False).split()
        pn = bb.data.getVar("PN", d, True)
        if "native" in pn:
                native = "-native"
        else:
                native = ""
        for x in [ 'cookies', 'crypto-auth', 'dict', 'file', 'ftp', 'http', 'telnet', 'tftp', 'ipv6' ]:
                if x in f:
                        oeconf += " --enable-%s" % x
                else:
                        oeconf += " --disable-%s" % x
        if 'zlib' in f:
                oeconf += " --with-zlib=${STAGING_LIBDIR}/../"
                deps.append("zlib" + native)
        else:
                oeconf += " --without-zlib"
        if 'gnutls' in f:
                oeconf += " --with-gnutls=${STAGING_BINDIR_CROSS}"
                deps.append("gnutls" + native)
        else:
                oeconf += " --without-gnutls"
        if 'openssl' in f:
                oeconf += " --with-ssl=${STAGING_LIBDIR}/../"
                deps.append("openssl" + native)
        else:
                oeconf += " --without-ssl"
        if 'ares' in f:
                oeconf += " --enable-ares"
                deps.append("c-ares" + native)
        else:
                oeconf += " --disable-ares"
        bb.data.setVar('EXTRA_OECONF', oeconf, d)
        bb.data.setVar('DEPENDS', " ".join(deps), d)
}

do_configure_prepend() {
	sed -i s:OPT_GNUTLS/bin:OPT_GNUTLS:g configure.ac
}

do_stage () {
	autotools_stage_all
}
