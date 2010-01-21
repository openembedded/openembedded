DESCRIPTION = "XML-NamespaceSupport"
SECTION = "libs"
LICENSE = ""
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PERIGRIN/XML-NamespaceSupport-${PV}.tar.gz;name=namespacesupport"

SRC_URI[namespacesupport.md5sum] = "0a760067d4b517672f064e911679c509"
SRC_URI[namespacesupport.sha256sum] = "a57357ac22959a5093a19177a0d541a478595d538afef659c19ae1e75849833e"

S = "${WORKDIR}/XML-NamespaceSupport-${PV}"

inherit cpan

BBCLASSEXTEND="native"

