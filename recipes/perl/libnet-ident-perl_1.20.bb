DESCRIPTION = "Net::Ident - lookup the username on the remote end of a TCP/IP connection"
SECTION = "libs"
LICENSE = "Artistic|GPL"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JP/JPC/Net-Ident-${PV}.tar.gz;name=net-ident-perl-${PV}"
SRC_URI[net-ident-perl-1.20.md5sum] = "70f265f46548675be01977d3c9eed570"
SRC_URI[net-ident-perl-1.20.sha256sum] = "c8370f21562c91d808ed37e105f95c5ba76b91d14186861d24832ccea094000c"

S = "${WORKDIR}/Net-Ident-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
