DESCRIPTION = "ESMTP is a user-configurable relay-only MTA \
with a sendmail-compatible syntax, based on libESMTP and \
supporting the AUTH (including the CRAM-MD5 and NTLM SASL \
mechanisms) and StartTLS SMTP extensions."
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "libesmtp"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/esmtp/esmtp-${PV}.tar.bz2"

# Have to set this or we get -L/lib in LDFLAGS
EXTRA_OECONF = "--with-libesmtp=${STAGING_EXECPREFIXDIR}"

inherit autotools
