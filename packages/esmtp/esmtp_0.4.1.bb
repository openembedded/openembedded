SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "libesmtp"
DESCRIPTION = "ESMTP is a user-configurable relay-only MTA \
with a sendmail-compatible syntax, based on libESMTP and \
supporting the AUTH (including the CRAM-MD5 and NTLM SASL \
mechanisms) and StartTLS SMTP extensions."

SRC_URI = "${SOURCEFORGE_MIRROR}/esmtp/esmtp-${PV}.tar.bz2"

inherit autotools
