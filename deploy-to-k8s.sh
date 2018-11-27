#!/bin/bash
export CIRCLE_BUILD_NUM_DOCKER=0.1.1
sed "s/BUILD_VERSION/$CIRCLE_BUILD_NUM_DOCKER/g" inventory-service-kube.yaml > build/inventory-service-kube.yaml
kubectl apply -f build/inventory-service-kube.yaml
