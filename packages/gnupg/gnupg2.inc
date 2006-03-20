SECTION = "console/utils"
DESCRIPTION = "gnupg - GNU privacy guard - development version"
HOMEPAGE = "http://www.gnupg.org/"
LICENSE = "GPLv2"
# DEPENDS = "zlib libgpg-error libgcrypt libassuan ksba opensc"
DEPENDS = "zlib libgpg-error libgcrypt libassuan"

inherit autotools gettext

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/alpha/gnupg/gnupg-${PV}.tar.bz2"
S = "${WORKDIR}/gnupg-${PV}"
libexecdir := "${libexecdir}/gnupg2"
FILES_${PN} += "${datadir}/gnupg"

# NOTE: gpgsm and scdaemon binaries aren't buildable if you dont have libksba. -CL
# --with-ksba-prefix=${STAGING_LIBDIR}/..

# NOTE: opensc is needed by the scdaemon binary.  if you don't have opensc, it can
# only build a limited scdaemon. -CL
# --with-opensc-prefix=${STAGING_LIBDIR}/..

# NOTE: given those facts, the current build will disable scdaemon and gpgsm.
# Threads are disabled currently to avoid the pth dependency. -CL

EXTRA_OECONF = "--disable-ldap \
		--with-zlib=${STAGING_LIBDIR}/.. \
		--with-gpg-error-prefix=${STAGING_BINDIR}/.. \
		--with-libgcrypt-prefix=${STAGING_BINDIR}/.. \
		--with-libassuan-prefix=${STAGING_BINDIR}/.. \
		--with-pth-prefix=${STAGING_BINDIR}/.. \
		--with-opensc-prefix=${STAGING_BINDIR}/.. \
		--with-ksba-prefix=${STAGING_BINDIR}/.. \
		--disable-threads \
		--disable-gpgsm \
		--disable-scdaemon"

# Bypass the tests
EXTRA_OEMAKE += "'TESTS_ENVIRONMENT=/bin/true'"

#   --disable-gpg           do not build the gpg program
#   --disable-gpgsm         do not build the gpgsm program
#   --disable-agent         do not build the agent program
#   --disable-scdaemon      do not build the scdaemon program
#   --enable-agent-only     build only the gpg-agent
#   --disable-exec          disable all external program execution
#   --disable-photo-viewers disable photo ID viewers
#   --disable-keyserver-helpers  disable all external keyserver support
#   --disable-ldap          disable LDAP keyserver interface
#   --disable-hkp           disable HKP keyserver interface
#   --disable-mailto        disable email keyserver interface
#   --disable-keyserver-path disable the exec-path option for keyserver helpers
#   --disable-largefile     omit support for large files
#   --disable-threads       allow building without Pth support
#   --disable-dns-srv       disable the use of DNS SRV in HKP
#   --disable-nls           do not use Native Language Support
#   --disable-rpath         do not hardcode runtime library paths
#   --disable-regex         do not handle regular expressions in trust sigs
#   --with-agent-pgm=PATH  Use PATH as the default for the agent)
#   --with-pinentry-pgm=PATH  Use PATH as the default for the pinentry)
#   --with-scdaemon-pgm=PATH  Use PATH as the default for the scdaemon)
#   --with-dirmngr-pgm=PATH  Use PATH as the default for the dirmngr)
#   --with-protect-tool-pgm=PATH  Use PATH as the default for the protect-tool)
#   --with-photo-viewer=FIXED_VIEWER  set a fixed photo ID viewer
#   --with-capabilities     use linux capabilities default=no
#   --with-gpg-error-prefix=PFX
#                           prefix where GPG Error is installed (optional)
#   --with-libgcrypt-prefix=PFX
#                           prefix where LIBGCRYPT is installed (optional)
#   --with-libassuan-prefix=PFX
#                           prefix where LIBASSUAN is installed (optional)
#   --with-ksba-prefix=PFX  prefix where KSBA is installed (optional)
#   --with-opensc-prefix=PFX
#                           prefix where OpenSC is installed (optional)
#   --with-pth-prefix=PFX   prefix where GNU Pth is installed (optional)
#   --with-mailprog=NAME    use "NAME -t" for mail transport
#   --with-libiconv-prefix[=DIR]  search for libiconv in DIR/include and DIR/lib
#   --without-libiconv-prefix     don't search for libiconv in includedir and libdir
#   --with-included-gettext use the GNU gettext library included here
#   --with-libintl-prefix[=DIR]  search for libintl in DIR/include and DIR/lib
#   --without-libintl-prefix     don't search for libintl in includedir and libdir
#   --with-included-regex   use the included GNU regex library
#   --with-zlib=DIR         use libz in DIR
#   --with-pkits-tests      run the PKITS based tests
