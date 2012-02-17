require openjdk-6-release-6b24.inc

PR = "${INC_PR}.0"

ICEDTEA = "icedtea6-1.11.1"

SRC_URI[iced.md5sum] = "e51d9d2f0328cc5aa7a00943abd96ed6"
SRC_URI[iced.sha256sum] = "bafb0e21e1edf5ee22871b13dbc0a8a0d3efd894551fb91d5f59783069b6912c"

CACAO_VERSION = "cff92704c4e0"
SRC_URI[cacao.md5sum] = "40b811b8b7f01b51cd21e62255691bc7"
SRC_URI[cacao.sha256sum] = "dc768c9d097fb056ad34fc6d5a57e8fd4f3b24bf515be92acc5ee4208160eb3f"

JAMVM_VERSION = "4617da717ecb05654ea5bb9572338061106a414d"
SRC_URI[jamvm.md5sum] = "740c2587502831cac6797d1233a7e27b"
SRC_URI[jamvm.sha256sum] = "47fce7bd556c1b1d29a93b8c45497e0d872b48b7f535066b303336f29d0f0d8d"

FILESPATH =. "${FILE_DIRNAME}/openjdk-6-6b24:"
