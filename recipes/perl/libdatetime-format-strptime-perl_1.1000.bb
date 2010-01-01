DESCRIPTION = "DateTime::Format::Strptime - Parse and format strp and strf time patterns"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RI/RICKM/DateTime-Format-Strptime-1.1000.tgz"

S = "${WORKDIR}/DateTime-Format-Strptime-${PV}"

inherit cpan

BBCLASSEXTEND="native"
