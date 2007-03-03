DESCRIPTION = "Timezone data"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "tzcode-native"

PROVIDES = "tzdata tzdata-misc tzdata-posix tzdata-right tzdata-africa \
            tzdata-americas tzdata-antarctica tzdata-arctic tzdata-asia \
            tzdata-atlantic tzdata-australia tzdata-europe tzdata-pacific"
RPROVIDES = "tzdata"
RCONFLICTS= "timezone-africa timezone-america timezone-antarctica \
             timezone-arctic timezone-asia timezone-atlantic \
             timezone-australia timezone-europe timezone-indian \
             timezone-iso3166.tab timezone-pacific timezone-zone.tab"

PR = "r0"

SRC_URI = "ftp://elsie.nci.nih.gov/pub/tzdata${PV}.tar.gz"

S = "${WORKDIR}"

TZONES= "africa antarctica asia australasia europe northamerica southamerica  \
         factory solar87 solar88 solar89 etcetera backward systemv \
#        pacificnew \
        "

do_compile () {
        for zone in ${TZONES}; do \
            zic -d ${WORKDIR}/usr/share/zoneinfo -L /dev/null \
                -y ${S}/yearistype.sh ${S}/${zone} ; \
            zic -d ${WORKDIR}/usr/share/zoneinfo/posix -L /dev/null \
                -y ${S}/yearistype.sh ${S}/${zone} ; \
            zic -d ${WORKDIR}/usr/share/zoneinfo/right -L ${S}/leapseconds \
                -y ${S}/yearistype.sh ${S}/${zone} ; \
        done
}

do_install () {
        install -d ${D}/usr ${D}/usr/share ${D}/usr/share/zoneinfo
        cp -pPR ${S}/usr ${D}/
}

# Packages primarily organized by directory with a major city
# in most time zones in the base package

PACKAGES = "tzdata tzdata-misc tzdata-posix tzdata-right tzdata-africa \
    tzdata-americas tzdata-antarctica tzdata-arctic tzdata-asia \
    tzdata-atlantic tzdata-australia tzdata-europe tzdata-pacific"

FILES_tzdata-africa += "/usr/share/zoneinfo/Africa/*"
RPROVIDES_tzdata-africa = "tzdata-africa"

FILES_tzdata-americas += "/usr/share/zoneinfo/America/*  \
                /usr/share/zoneinfo/US/*                \
                /usr/share/zoneinfo/Brazil/*            \
                /usr/share/zoneinfo/Canada/*            \
                /usr/share/zoneinfo/Mexico/*            \
                /usr/share/zoneinfo/Chile/*"
RPROVIDES_tzdata-americas = "tzdata-americas"

FILES_tzdata-antarctica += "/usr/share/zoneinfo/Antarctica/*"
RPROVIDES_tzdata-antarctica = "tzdata-antarctica"

FILES_tzdata-arctic += "/usr/share/zoneinfo/Arctic/*"
RPROVIDES_tzdata-arctic = "tzdata-arctic"

FILES_tzdata-asia += "/usr/share/zoneinfo/Asia/*        \
                /usr/share/zoneinfo/Indian/*            \
                /usr/share/zoneinfo/Mideast/*"
RPROVIDES_tzdata-asia = "tzdata-asia"

FILES_tzdata-atlantic += "/usr/share/zoneinfo/Atlantic/*"
RPROVIDES_tzdata-atlantic = "tzdata-atlantic"

FILES_tzdata-australia += "/usr/share/zoneinfo/Australia/*"
RPROVIDES_tzdata-australia = "tzdata-australia"

FILES_tzdata-europe += "/usr/share/zoneinfo/Europe/*"
RPROVIDES_tzdata-europe = "tzdata-europe"

FILES_tzdata-pacific += "/usr/share/zoneinfo/Pacific/*"
RPROVIDES_tzdata-pacific = "tzdata-pacific"

FILES_tzdata-posix += "/usr/share/zoneinfo/posix/*"
RPROVIDES_tzdata-posix = "tzdata-posix"

FILES_tzdata-right += "/usr/share/zoneinfo/right/*"
RPROVIDES_tzdata-right = "tzdata-right"


FILES_tzdata-misc += "/usr/share/zoneinfo/Cuba           \
                /usr/share/zoneinfo/Egypt                \
                /usr/share/zoneinfo/Eire                 \
                /usr/share/zoneinfo/Factory              \
                /usr/share/zoneinfo/GB-Eire              \
                /usr/share/zoneinfo/Hongkong             \
                /usr/share/zoneinfo/Iceland              \
                /usr/share/zoneinfo/Iran                 \
                /usr/share/zoneinfo/Israel               \
                /usr/share/zoneinfo/Jamaica              \
                /usr/share/zoneinfo/Japan                \
                /usr/share/zoneinfo/Kwajalein            \
                /usr/share/zoneinfo/Libya                \
                /usr/share/zoneinfo/Navajo               \
                /usr/share/zoneinfo/Poland               \
                /usr/share/zoneinfo/Portugal             \
                /usr/share/zoneinfo/Singapore            \
                /usr/share/zoneinfo/Turkey"
RPROVIDES_tzdata-misc = "tzdata-misc"


FILES_${PN} += "/usr/share/zoneinfo/Pacific/Honolulu     \
                /usr/share/zoneinfo/America/Anchorage    \
                /usr/share/zoneinfo/America/Los_Angeles  \
                /usr/share/zoneinfo/America/Denver       \
                /usr/share/zoneinfo/America/Chicago      \
                /usr/share/zoneinfo/America/New_York     \
                /usr/share/zoneinfo/America/Caracas      \
                /usr/share/zoneinfo/America/Sao_Paulo    \
                /usr/share/zoneinfo/Europe/London        \
                /usr/share/zoneinfo/Europe/Paris         \
                /usr/share/zoneinfo/Africa/Cairo         \
                /usr/share/zoneinfo/Europe/Moscow        \
                /usr/share/zoneinfo/Asia/Dubai           \
                /usr/share/zoneinfo/Asia/Karachi         \
                /usr/share/zoneinfo/Asia/Dhaka           \
                /usr/share/zoneinfo/Asia/Bankok          \
                /usr/share/zoneinfo/Asia/Hong_Kong       \
                /usr/share/zoneinfo/Asia/Tokyo           \
                /usr/share/zoneinfo/Australia/Sydney     \
                /usr/share/zoneinfo/Pacific/Noumea       \
                /usr/share/zoneinfo/CET                  \
                /usr/share/zoneinfo/CST6CDT              \
                /usr/share/zoneinfo/EET                  \
                /usr/share/zoneinfo/EST                  \
                /usr/share/zoneinfo/EST5EDT              \
                /usr/share/zoneinfo/GB                   \
                /usr/share/zoneinfo/GMT                  \
                /usr/share/zoneinfo/GMT+0                \
                /usr/share/zoneinfo/GMT-0                \
                /usr/share/zoneinfo/GMT0                 \
                /usr/share/zoneinfo/Greenwich            \
                /usr/share/zoneinfo/HST                  \
                /usr/share/zoneinfo/MET                  \
                /usr/share/zoneinfo/MST                  \
                /usr/share/zoneinfo/MST7MDT              \
                /usr/share/zoneinfo/NZ                   \
                /usr/share/zoneinfo/NZ-CHAT              \
                /usr/share/zoneinfo/PRC                  \
                /usr/share/zoneinfo/PST8PDT              \
                /usr/share/zoneinfo/ROC                  \
                /usr/share/zoneinfo/ROK                  \
                /usr/share/zoneinfo/UCT                  \
                /usr/share/zoneinfo/UTC                  \
                /usr/share/zoneinfo/Universal            \
                /usr/share/zoneinfo/W-SU                 \
                /usr/share/zoneinfo/WET                  \
                /usr/share/zoneinfo/Zulu                 \
                /usr/share/zoneinfo/Etc/*"
