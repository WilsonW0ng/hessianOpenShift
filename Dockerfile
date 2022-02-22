FROM 192.168.3.58:5858/smartbox/gtos_base_image:1.0.1
LABEL maintainer="PSA"

RUN mkdir -p /apps/cells/deploy
ADD deploy.zip /apps/cells/deploy

ENV TOMAPPS /apps/cells/opsBM/tomapps
RUN mkdir -p ${TOMAPPS}
RUN chmod -R g+w ${TOMAPPS}
ADD TomEEFrameworkServiceEAR.ear ${TOMAPPS}
ADD TomEEOperationServiceEAR.ear ${TOMAPPS}
ADD TomEEWebOperationsEAR.ear ${TOMAPPS}
ADD TomEEOpsRestEAR.ear ${TOMAPPS}
ADD TomEEDemandForOpsEAR.ear ${TOMAPPS}
ADD smartbox.adapter.demand.tomee-ear.ear ${TOMAPPS}
ADD smartbox.adapter.ops-tomee-ear.ear ${TOMAPPS}

ENV INSTANCES /apps/instances/opsBM
RUN mkdir -p ${INSTANCES}/conf
ADD logging.properties ${INSTANCES}/conf
ADD system.properties ${INSTANCES}/conf
ADD hazelcast.xml ${INSTANCES}/conf
ADD SecurityEncryption.jar ${INSTANCES}/lib
ADD SecurityKey.dat ${INSTANCES}/lib
ADD SecurityRoleMapper.jar ${INSTANCES}/lib
RUN mkdir -p ${INSTANCES}/bin
ADD setenv.sh ${INSTANCES}/bin
ADD start.sh /apps/tomee/bin
HEALTHCHECK --interval=5s --timeout=1s CMD curl -f http://localhost/ || exit 1

ENTRYPOINT ["start.sh"]
CMD ["run"]
