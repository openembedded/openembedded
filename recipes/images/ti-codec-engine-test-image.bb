# This image is a bare-bones image to test the TI Codec Engine

require minimal-image.bb

IMAGE_INSTALL += "ti-codec-engine-apps"

export IMAGE_BASENAME = "ti-codec-engine-test-image"

