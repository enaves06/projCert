# Create runtime image
FROM devopsedu/webapp AS intermediate


# install git
RUN apt-get update
RUN apt-get install -y git

# add credentials on build
# ARG SSH_PRIVATE_KEY
# RUN mkdir /root/.ssh/
# RUN echo "${SSH_PRIVATE_KEY}" > /root/.ssh/id_rsa

# make sure your domain is accepted
# RUN touch /root/.ssh/known_hosts
# RUN ssh-keyscan github.com >> /root/.ssh/known_hosts

WORKDIR /var/www/html

#ADD repo-key /
#RUN \
#  chmod 600 /repo-key && \  
#  echo "IdentityFile /repo-key" >> /etc/ssh/ssh_config && \  
#  echo -e "StrictHostKeyChecking no" >> /etc/ssh/ssh_config && \  
#  git clone https://github.com/enaves06/projCert.git

COPY /projCert/website /var/www/html

#ENTRYPOINT ["/usr/sbin/apache2", "-k", "start"]

#ENV APACHE_RUN_USER www-data
#ENV APACHE_RUN_GROUP www-data
#ENV APACHE_LOG_DIR /var/log/apache2

EXPOSE 80
CMD apachectl -D FOREGROUND
