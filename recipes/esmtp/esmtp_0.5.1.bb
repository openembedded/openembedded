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

SRC_URI[md5sum] = "9f0b809e891a548910f099efc4315b02"
SRC_URI[sha256sum] = "ae023107f8e0c872a2bb6f23a9a5f019b254e9b7eebd20a309af996d9cb7e38e"
