DESCRIPTION = "Nmap is a command line portscanner."
HOMEPAGE = "http://www.insecure.org/nmap/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "libpcap libpcre"
PR = "r2"

inherit autotools

SRC_URI = "http://download.insecure.org/nmap/dist-old/nmap-${PV}.tar.bz2 \
	   file://autofoo.patch;patch=1 \
	   file://remove_gtk.patch;patch=1"
S = "${WORKDIR}/nmap-${PV}"

EXTRA_OECONF = "--with-pcap=linux \
		--with-libpcap=${STAGING_LIBDIR}/.. \
		--with-libpcre=${STAGING_LIBDIR}/.. \
		--without-nmapfe \
		--without-openssl"
EXTRA_OEMAKE = "STRIPPROG=${STRIP}"

PARALLEL_MAKE = ""

CXXFLAGS_append = " -fpermissive"
# Ugly hack follows -- their configure.ac doesnt match their configure ..
# doesnt include a check for the length type in recvfrom, so we hack it here
CPPFLAGS_append = " -Drecvfrom6_t=socklen_t"

do_install () {
	oe_runmake 'prefix=${D}${prefix}' \
		   'exec_prefix=${D}${exec_prefix}' \
		   'bindir=${D}${bindir}' \
		   'sbindir=${D}${sbindir}' \
		   'mandir=${D}${mandir}' \
		   'datadir=${D}${datadir}' \
		   'nmapdatadir=${D}${datadir}/nmap' \
		   install
}
