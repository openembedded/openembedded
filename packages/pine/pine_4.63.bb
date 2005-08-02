DESCRIPTION = "Pine(R) - a Program for Internet News & Email" 
PR = "r1"
SECTION = "console/network" 
LICENSE = "Pine" 
DEPENDS = "ncurses libldap" 
RDEPENDS_pine = "pico" 
HOMEPAGE = "http://www.washington.edu/pine/" 
MAINTAINER = "Michael 'Mickey' Lauer <mickey_at_Vanille.de>" 

SRC_URI = "ftp://ftp.cac.washington.edu/pine/pine.tar.bz2 \
	file://pine-4.63/pine-4.63-r2-chappa-all.patch;patch=1 \
	file://pine-4.63/pine-4.62-spooldir-permissions.patch;patch=1 \
	file://pine-4.63/pine-4.30-ldap.patch;patch=1 \
	file://pine-4.63/pine-ldap3.patch;patch=1 \
	file://pine-4.63/pine-4.56-passfile.patch;patch=1 \
	file://pine-4.63/pine-4.61-largeterminal.patch;patch=1 \
	file://pine-4.63/pine-4.31-segfix.patch;patch=1 \
	file://pine-4.63/pine-4.40-lockfile-perm.patch;patch=1 \
	file://pine-4.63/imap-2000-time.patch;patch=1 \
	file://pine-4.63/transparency.patch;patch=1 \
	file://pine-4.63/pine-4.61-subjectlength.patch;patch=1"

S = "${WORKDIR}/pine${PV}" 

inherit autotools 

# 
# ~lart Pine's build structure... 
# 
PARALLEL_MAKE = "" 
EXTRA_OEMAKE = "-e" 
export MAKE = 'MAKE="make -e" make -e' 

CFLAGS += "-I${S}/imap/c-client" 
LDFLAGS += "${S}/imap/c-client/c-client.a -lssl -lcrypt" 

export SSLDEFINES = "-DSSL_CERT_DIRECTORY=\\"/etc/ssl/certs\\" -DSSL_KEY_DIRECTORY=\\"/etc/ssl/private\\"" 
export SSLCFLAGS = "${CFLAGS} -I${STAGING_INCDIR}/openssl ${SSLDEFINES}" 
export SSLLDFLAGS = "-lssl -lcrypt ${LDFLAGS} -L${STAGING_LIBDIR}/openssl" 
export LDAPCFLAGS = "-DENABLE_LDAP"
export LDAPLIBS = "-lldap -llber"
export EXTRALDFLAGS = "${LDFLAGS}" 

do_configure() { 
 ln -sf ${S}/imap/c-client ${S}/c-client 
 cd ${S}/pico/osdep && \ 
 ${BUILD_CC} -o includer includer.c 
 cd ${S}/pine/osdep && \ 
 ${BUILD_CC} -o includer includer.c 
 mkdir ${S}/ldap
 cd ${S}/ldap &&
 ln -sf ${STAGING_INCDIR} include &&
 ln -sf ${STAGING_LIBDIR} libraries
 cd ${S}
 sed -e "s:/usr/local/lib/pine.conf:/etc/pine.conf:" \
     -i "${S}/pine/osdep/os-lnx.h" || exit 1
 ls -l ${S}/contrib/ldap-setup
} 

do_compile() { 
 unset CFLAGS && unset LDFLAGS 
 cd ${S}/imap && oe_runmake slx 
 
 for i in pico pine 
 do 
 cd ${S}/$i && oe_runmake -f makefile.lnx 
 done 
} 

BINARIES = "imap/mailutil/mailutil imap/mlock/mlock pico/pico pico/pilot pine/pine" 

do_install() { 
 install -d 0644 ${D}${bindir} 
 for binary in ${BINARIES} 
 do 
 install -m 0755 $binary ${D}${bindir} 
 done 
} 

PACKAGES = "pico pine" 
FILES_pico = "${bindir}/pico ${bindir}/pilot" 

