
/* Copyright (c) 2009, Code Aurora Forum. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Code Aurora nor
 *       the names of its contributors may be used to endorse or promote
 *       products derived from this software without specific prior written
 *       permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

#ifndef _KGSL_DRM_H_
#define _KGSL_DRM_H_

#include "drm.h"

#define DRM_KGSL_GEM_CREATE 0x00
#define DRM_KGSL_GEM_PREP   0x01
#define DRM_KGSL_GEM_SETMEMTYPE 0x02
#define DRM_KGSL_GEM_GETMEMTYPE 0x03
#define DRM_KGSL_GEM_MMAP 0x04
#define DRM_KGSL_GEM_ALLOC 0x05
#define DRM_KGSL_GEM_BIND_GPU 0x06
#define DRM_KGSL_GEM_UNBIND_GPU 0x07

#define DRM_IOCTL_KGSL_GEM_CREATE \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_CREATE, struct drm_kgsl_gem_create)

#define DRM_IOCTL_KGSL_GEM_PREP \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_PREP, struct drm_kgsl_gem_prep)

#define DRM_IOCTL_KGSL_GEM_SETMEMTYPE \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_SETMEMTYPE, \
struct drm_kgsl_gem_memtype)

#define DRM_IOCTL_KGSL_GEM_GETMEMTYPE \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_GETMEMTYPE, \
struct drm_kgsl_gem_memtype)

#define DRM_IOCTL_KGSL_GEM_MMAP \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_MMAP, struct drm_kgsl_gem_mmap)

#define DRM_IOCTL_KGSL_GEM_ALLOC \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_ALLOC, struct drm_kgsl_gem_alloc)

#define DRM_IOCTL_KGSL_GEM_BIND_GPU \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_BIND_GPU, struct drm_kgsl_gem_bind_gpu)

#define DRM_IOCTL_KGSL_GEM_UNBIND_GPU \
DRM_IOWR(DRM_COMMAND_BASE + DRM_KGSL_GEM_UNBIND_GPU, \
struct drm_kgsl_gem_bind_gpu)

#define DRM_KGSL_GEM_TYPE_EBI          0
#define DRM_KGSL_GEM_TYPE_SMI          1
#define DRM_KGSL_GEM_TYPE_KMEM         2
#define DRM_KGSL_GEM_TYPE_KMEM_NOCACHE 3

struct drm_kgsl_gem_create {
	uint32_t size;
	uint32_t handle;
};

struct drm_kgsl_gem_prep {
	uint32_t handle;
	uint32_t phys;
	uint64_t offset;
};

struct drm_kgsl_gem_memtype {
	uint32_t handle;
	uint32_t type;
};

struct drm_kgsl_gem_mmap {
	uint32_t handle;
	uint32_t size;
	uint32_t hostptr;
	uint64_t offset;
};

struct drm_kgsl_gem_alloc {
	uint32_t handle;
	uint64_t offset;
};

struct drm_kgsl_gem_bind_gpu {
	uint32_t handle;
	uint32_t gpuptr;
};

#endif
