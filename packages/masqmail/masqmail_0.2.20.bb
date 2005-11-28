# MasqMail from http://innominate.org/kurth/masqmail/
DESCRIPTION = "MasqMail is a mail server designed for hosts that do not have a permanent internet connection eg. a home network or a single host at home. It has special support for connections to different ISPs. It replaces sendmail or other MTAs such as qmail or exim."
HOMEPAGE = "http://innominate.org/kurth/masqmail/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "glib-2.0"

SRC_URI = "http://innominate.org/kurth/masqmail/download/masqmail-${PV}.tar.gz"
SRC_URI += "file://configure-ac-glib-2-0.patch;patch=1"

EXTRA_OECONF += "--disable-glibtest"
EXTRA_OECONF += "--disable-resolver"
EXTRA_OECONF += "--disable-debug"

# These are the standard Debian values for ownership of the programs,
# this stuff fakes out the install script chown operations then replicates
# them by setting the ipkg owner/group to the desired values - everything
# ends up owned by the nominated user.
MAIL_USER ?= "mail"
MAIL_GROUP ?= "mail"

EXTRA_OECONF += "--with-user=$(id -u)"
EXTRA_OECONF += "--with-group=$(id -g)"

IPKGBUILDCMD = "ipkg-build -o ${MAIL_USER} -g ${MAIL_GROUP}"

inherit autotools
