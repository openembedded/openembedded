require openjdk-6-release-6b18.inc

PR = "${INC_PR}.1"

FILESPATHPKG =. "openjdk-6-6b18-1.8.5:openjdk-6-6b18-1.8:"

ICEDTEA = "icedtea6-1.8.5"

OEPATCHES += " \
              file://cacao-libtoolize.patch \
             "


SRC_URI[iced.md5sum] = "65b84d9dfd7845acab9b9226ea136546"
SRC_URI[iced.sha256sum] = "1ee081368587507e7ea75bd3351be0eafadd3f7020930db68448bcec6fa5c452"
