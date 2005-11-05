LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "The sgml-common package gathers very basic \
stuff necessary to work with SGML and XML, such as xml.dcl, \
a SGML declaration of XML; iso-entities, a list of the basic \
SGML ISO entities; and install-catalog, a script used to \
add entries to (or remove entries from) centralized catalogs \
whose entries are pointers to SGML open catalogs, \
as defined by OASIS."

FILES_sgml-common_append = " ${datadir}/sgml"

SRC_URI = "ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/sgml-common-${PV}.tgz \
	   file://autohell.patch;patch=1"

inherit autotools
