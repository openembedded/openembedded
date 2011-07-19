DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT"

DEPENDS = "openssl"

PR = "r1"

def nodejs_get_gcc_version(d):
    import subprocess,os,bb
    if os.path.exists(bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc'):
        return subprocess.Popen([bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc', '-v'], stderr=subprocess.PIPE).communicate()[1].splitlines()[-1].split()[2]

SRC_URI = " \
  http://nodejs.org/dist/node-v${PV}.tar.gz \
  file://libev-cross-cc_${PV}.patch \
"

SRC_URI += "${@["", "file://0001-Add-missing-compiler-flags-for-GCC-4.3.patch"][nodejs_get_gcc_version(d) <= "4.3.3"]}"

SRC_URI[md5sum] = "18f89256751f9b8e27dee8494f508171"
SRC_URI[sha256sum] = "4a30bd9963373cb86a994479bdd451ab3b6f2124f0089493366315da79d3408e"

S = "${WORKDIR}/node-v${PV}"

# v8 errors out if you have set CCACHE
CCACHE = ""

do_configure () {
  ./configure --prefix=${prefix} --without-snapshot
}

do_compile () {
  make
}

do_install () {
  DESTDIR=${D} oe_runmake install
}

BBCLASSEXTEND = "native"
