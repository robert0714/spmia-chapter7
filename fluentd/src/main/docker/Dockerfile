FROM fluent/fluentd
# USER fluent
# WORKDIR /home/fluent
# ENV PATH /home/fluent/.gem/ruby/2.3.0/bin:$PATH 
 

# below RUN includes plugin as examples elasticsearch is not required
# you may customize including plugins as you wish

RUN apk add --update --virtual .build-deps \
        sudo build-base ruby-dev \
 && sudo gem install \
         fluent-plugin-secure-forward  \     
 && sudo gem install \
        fluent-plugin-elasticsearch \
 && sudo gem sources --clear-all \
 && apk del .build-deps \
 && rm -rf /var/cache/apk/* \
           /home/fluent/.gem/ruby/2.4.0/cache/*.gem 
           
#RUN apt-get install make
#RUN apt-get install -y gcc
#RUN apt-get install -y ruby-full
#RUN mkdir -p /usr/local/organizationservice
#RUN gem install fluentd
#RUN sudo gem install fluent-plugin-elasticsearch

ADD fluentd.conf /home/fluent/
EXPOSE 24224
EXPOSE 9800
#VOLUME /fluentd/log

CMD fluentd -c /home/fluent/fluentd.conf -vv

