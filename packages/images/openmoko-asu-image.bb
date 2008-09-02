#------------------------------------------------------
# Openmoko Qtopia/X11 Image Recipe
#------------------------------------------------------

require openmoko-minimal-image.bb

IMAGE_INSTALL += "\
                  task-openmoko-asu \
                  task-openmoko-basic \
                  "
