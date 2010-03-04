DESCRIPTION = "snort - a free lightweight network intrusion detection system for UNIX and Windows."
HOMEPAGE = "http://www.snort.org/"
LICENSE = "GPL"
DEPENDS = "libpcap libnet libpcre"
RDEPENDS = "libpcap libnet libpcre barnyard"

PR = "r1"

SRC_URI = " http://dl.snort.org/snort-current/${P}.tar.gz;name=tarball \
            file://snort.fix.configure.in.HACK;patch=1 \
          "
SRC_URI[tarball.md5sum] = "ef02aaad54746603f2cb3236fe962128"
SRC_URI[tarball.sha256sum] = "a7d9eb16427514d00926e9892c4a92b6ff1fd0f79555d8f8dce91dfa14112e6a"

S = "${WORKDIR}/${P}"

#snort does not like parallel make!
PARALLEL_MAKE = ""

inherit autotools pkgconfig

#fix path of pc file
do_install_prepend() {
	sed -i -e 's:-Wl,-rpath-link,${STAGING_LIBDIR}::g' -e 's:-isystem${STAGING_INCDIR}::g'  snort.pc
}

